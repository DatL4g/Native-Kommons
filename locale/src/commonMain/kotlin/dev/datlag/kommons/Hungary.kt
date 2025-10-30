package dev.datlag.kommons


data object Hungary : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("HU")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("HUN")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(348)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(36)
}