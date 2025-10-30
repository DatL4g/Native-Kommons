package dev.datlag.kommons


data object Cuba : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("CU")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("CUB")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(192)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(53)
}