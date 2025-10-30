package dev.datlag.kommons


data object WallisAndFutuna : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("WF")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("WLF")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(876)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(681)
}