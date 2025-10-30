package dev.datlag.kommons


data object Mongolia : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("MN")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("MNG")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(496)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(976)
}